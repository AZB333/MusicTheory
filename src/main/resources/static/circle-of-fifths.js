const keys = [
    { major: 'C',  minor: 'Am',  accidentals: '0',        scale: ['C','D','E','F','G','A','B'],              relMinor: 'A minor',  parMinor: 'C minor' },
    { major: 'G',  minor: 'Em',  accidentals: '1♯ (F♯)',  scale: ['G','A','B','C','D','E','F♯'],             relMinor: 'E minor',  parMinor: 'G minor' },
    { major: 'D',  minor: 'Bm',  accidentals: '2♯ (F♯C♯)',scale: ['D','E','F♯','G','A','B','C♯'],           relMinor: 'B minor',  parMinor: 'D minor' },
    { major: 'A',  minor: 'F♯m', accidentals: '3♯',       scale: ['A','B','C♯','D','E','F♯','G♯'],          relMinor: 'F♯ minor', parMinor: 'A minor' },
    { major: 'E',  minor: 'C♯m', accidentals: '4♯',       scale: ['E','F♯','G♯','A','B','C♯','D♯'],         relMinor: 'C♯ minor', parMinor: 'E minor' },
    { major: 'B',  minor: 'G♯m', accidentals: '5♯ / 7♭',  scale: ['B','C♯','D♯','E','F♯','G♯','A♯'],        relMinor: 'G♯ minor', parMinor: 'B minor' },
    { major: 'F♯', minor: 'D♯m', accidentals: '6♯ / 6♭',  scale: ['F♯','G♯','A♯','B','C♯','D♯','E♯'],       relMinor: 'D♯ minor', parMinor: 'F♯ minor'},
    { major: 'D♭', minor: 'B♭m', accidentals: '5♭',       scale: ['D♭','E♭','F','G♭','A♭','B♭','C'],        relMinor: 'B♭ minor', parMinor: 'D♭ minor'},
    { major: 'A♭', minor: 'Fm',  accidentals: '4♭',       scale: ['A♭','B♭','C','D♭','E♭','F','G'],         relMinor: 'F minor',  parMinor: 'A♭ minor'},
    { major: 'E♭', minor: 'Cm',  accidentals: '3♭',       scale: ['E♭','F','G','A♭','B♭','C','D'],          relMinor: 'C minor',  parMinor: 'E♭ minor'},
    { major: 'B♭', minor: 'Gm',  accidentals: '2♭ (B♭E♭)',scale: ['B♭','C','D','E♭','F','G','A'],           relMinor: 'G minor',  parMinor: 'B♭ minor'},
    { major: 'F',  minor: 'Dm',  accidentals: '1♭ (B♭)',  scale: ['F','G','A','B♭','C','D','E'],            relMinor: 'D minor',  parMinor: 'F minor' },
];

let panel = document.getElementById('infoPanel');
const svg = document.getElementById('circle');
const NS = 'http://www.w3.org/2000/svg';
const N = 12;
const TAU = Math.PI * 2;
// Start at top (-90deg), go clockwise
const startOffset = (-Math.PI / 2) - (Math.PI / N);
const sliceAngle = TAU / N;

// Ring radii (in SVG units where circle r=1)
const R_OUT = 0.95;
const R_MID = 0.70;
const R_MIN = 0.44;
const R_IN  = 0.18;

let activeIndex = null;

function polarToXY(angle, r) {
    return [Math.cos(angle) * r, Math.sin(angle) * r];
}

function arcPath(r1, r2, startA, endA) {
    const [x1, y1] = polarToXY(startA, r2);
    const [x2, y2] = polarToXY(endA, r2);
    const [x3, y3] = polarToXY(endA, r1);
    const [x4, y4] = polarToXY(startA, r1);
    const large = (endA - startA) > Math.PI ? 1 : 0;
    return `M ${x1} ${y1} A ${r2} ${r2} 0 ${large} 1 ${x2} ${y2} L ${x3} ${y3} A ${r1} ${r1} 0 ${large} 0 ${x4} ${y4} Z`;
}

function drawTrebleClef(cx, cy, size) {
    const g = document.createElementNS(NS, 'g');
    g.setAttribute('transform', `translate(${cx},${cy}) scale(${size})`);
    const text = document.createElementNS(NS, 'text');
    text.setAttribute('text-anchor', 'middle');
    text.setAttribute('dominant-baseline', 'central');
    text.setAttribute('font-size', '1');
    text.setAttribute('fill', '#3a4560');
    text.setAttribute('font-family', 'serif');
    text.textContent = '𝄞';
    g.appendChild(text);
    return g;
}

const sliceGroups = [];
const majorLabels = [];
const minorLabels = [];

for (let i = 0; i < N; i++) {
    const startA = startOffset + i * sliceAngle;
    const endA   = startOffset + (i + 1) * sliceAngle;
    const midA   = (startA + endA) / 2;

    const group = document.createElementNS(NS, 'g');
    group.setAttribute('data-index', i.toString());
    group.style.cursor = 'pointer';

// Outer ring: major
    const outer = document.createElementNS(NS, 'path');
    outer.setAttribute('d', arcPath(R_MID, R_OUT, startA, endA));
    outer.setAttribute('class', 'slice-major');
    group.appendChild(outer);

// Middle ring: minor
    const mid = document.createElementNS(NS, 'path');
    mid.setAttribute('d', arcPath(R_MIN, R_MID, startA, endA));
    mid.setAttribute('class', 'slice-minor');
    group.appendChild(mid);

// Inner ring: notation
    const inner = document.createElementNS(NS, 'path');
    inner.setAttribute('d', arcPath(R_IN, R_MIN, startA, endA));
    inner.setAttribute('class', 'slice-notation');
    group.appendChild(inner);

// Major label
    const [mlx, mly] = polarToXY(midA, (R_MID + R_OUT) / 2);
    const majorTxt = document.createElementNS(NS, 'text');
    majorTxt.setAttribute('x', mlx);
    majorTxt.setAttribute('y', mly);
    majorTxt.setAttribute('class', 'label-major');
    majorTxt.textContent = keys[i].major;
    group.appendChild(majorTxt);
    majorLabels.push(majorTxt);

// Minor label
    const [mnx, mny] = polarToXY(midA, (R_MIN + R_MID) / 2);
    const minorTxt = document.createElementNS(NS, 'text');
    minorTxt.setAttribute('x', mnx);
    minorTxt.setAttribute('y', mny);
    minorTxt.setAttribute('class', 'label-minor');
    minorTxt.textContent = keys[i].minor;
    group.appendChild(minorTxt);
    minorLabels.push(minorTxt);

// Treble clef in inner ring
    const [clx, cly] = polarToXY(midA, (R_IN + R_MIN) / 2);
    const clef = drawTrebleClef(clx, cly, 0.055);
    group.appendChild(clef);

    group.addEventListener('click', () => selectKey(i));
    svg.appendChild(group);
    sliceGroups.push(group);
}


// Center circle
const centerCircle = document.createElementNS(NS, 'circle');
centerCircle.setAttribute('cx', '0');
centerCircle.setAttribute('cy', '0');
centerCircle.setAttribute('r', R_IN.toString());
centerCircle.setAttribute('fill', '#0f1420');
centerCircle.setAttribute('stroke', '#2a3245');
centerCircle.setAttribute('stroke-width', '0.008');
centerCircle.classList.add('center-circle');
svg.appendChild(centerCircle);

const centerText = document.createElementNS(NS, 'text');
centerText.setAttribute('x', '0');
centerText.setAttribute('y', '0');
centerText.setAttribute('class', 'center-label');
centerText.textContent = 'Circle of Fifths';
svg.appendChild(centerText);

function selectKey(index) {
    if (activeIndex === index) {
        // Deselect
        activeIndex = -1;
        panel.classList.remove('visible');
        panel.classList.add('hidden');
        panel.innerHTML = ``;
        return;
    }
    activeIndex = index;
    updateVisuals();
    showInfo(index);
}

function updateVisuals() {
    sliceGroups.forEach((group, index) => {
        const isActive = index === activeIndex;
        group.querySelector('.slice-major').classList.toggle('active', isActive);
        group.querySelector('.slice-minor').classList.toggle('active', isActive);
        group.querySelector('.slice-notation').classList.toggle('active', isActive);
        majorLabels[index].classList.toggle('active', isActive);
        minorLabels[index].classList.toggle('active', isActive);
    });
}

function showInfo(index) {
    const key = keys[index];
    const panel = document.getElementById('infoPanel');

    panel.innerHTML = `
    <h2 id="infoKey">${key.major} major</h2>
    <div class="minor-label">${key.minor} — relative minor</div>
    <div class="divider"></div>
    <div class="detail-row"><span>Sharps / Flats</span><span>${key.accidentals}</span></div>
    <div class="detail-row"><span>Relative Minor</span><span>${key.relMinor}</span></div>
    <div class="detail-row"><span>Parallel Minor</span><span>${key.parMinor}</span></div>
    <div class="notes-display" id="infoNotes"></div>
  `;

    const notesEl = document.getElementById('infoNotes');
    key.scale.forEach((n, idx) => {
        const chip = document.createElement('div');
        chip.className = 'note-chip' + (idx === 0 ? ' root' : '');
        chip.textContent = n;
        notesEl.appendChild(chip);
    });

    panel.classList.remove('hidden');
    panel.classList.add('visible');
}