document.addEventListener('DOMContentLoaded', () => {
    const pianoDiv = document.getElementById("piano-container");
    if(pianoDiv != null){
        drawPiano();
    }
});

const sleep = (ms) => new Promise(resolve => setTimeout(resolve, ms));


function playNote(audioFile) {
    const note = new Audio(audioFile);
    note.currentTime = 0;
    note.play();
}

function playChord(){
    const root = document.getElementById('root').value;
    const chordType = document.getElementById('chord-type').value;
    console.log("root value in method is " + root + " chord type in method is " + chordType);
    const audioFile = `audiofiles/chords/${chordType.toLowerCase()}/${root}4${chordType.toLowerCase()}Inversion0.wav`;
    const chordAudio = new Audio(audioFile);
    chordAudio.currentTime = 0;
    chordAudio.play().then(r => r);
}

function fetchChord(){
    const root = document.getElementById('root').value;
    const chordType = document.getElementById('chord-type').value;

    fetch(`/chord?root=${root}&chordType=${chordType}`)
        .then(res => res.json())
        .then(chord => {
            const noteNames = chord.notes.map(note => note.name).join('-');
            document.getElementById('result').innerHTML = `<p>${noteNames}</p>`;
            displayOnPiano(chord);
        });
}

function fancifyChord(){
    const root = document.getElementById('root').value;
    const chordType = document.getElementById('chord-type').value;
    let fancyChordType = "";
    if(chordType === "major"){
        fancyChordType = "major_seventh";
    }
    if(chordType === "minor"){
        fancyChordType = "minor_seventh";
    }
    fetch(`/chord?root=${root}&chordType=${fancyChordType}`)
        .then(res => res.json())
        .then(chord => {
            const noteNames = chord.notes.map(note => note.name).join('-');
            document.getElementById('result').innerHTML = `<p>${noteNames}</p>`;
            displayOnPiano(chord);
        });
}

function fetchScale(){
    const root = document.getElementById('root').value;
    const scaleType = document.getElementById('scale-type').value;

    fetch(`/scale?root=${root}&scaleType=${scaleType}`)
        .then(res => res.json())
        .then(scale => {
            const noteNames = scale.notes.map(note => note.name).join('-');
            document.getElementById('result').innerHTML = `<p>${noteNames}</p>`;
            displayOnPiano(scale);
        });
}

function playProgression() {
    const root = document.getElementById('root').value;
    const progressionType = document.getElementById('progression-type').value;

    fetch(`/progression?root=${root}&progressionType=${progressionType}`)
        .then(res => res.json())
        .then(progression => {
            const chordNames = progression.chords.map(chord => chord.displayName).join(" - ");
            document.getElementById('result').innerHTML = `<p>${chordNames}</p>`;

            let index = 0;
            function playNext() {
                if (index >= progression.chords.length) return;
                const chord = progression.chords[index];
                const audioFile = `audiofiles/chords/${chord.type.toLowerCase()}/${chord.root.toLowerCase()}4${chord.type.toLowerCase()}Inversion0.wav`;
                const audio = new Audio(audioFile);
                audio.play();
                index++;
                setTimeout(playNext, 1500); // play next chord after 1.5 seconds
            }
            playNext();
        });
}

function fetchProgression(){
    const root = document.getElementById('root').value;
    const progressionType = document.getElementById('progression-type').value;

    fetch(`/progression?root=${root}&progressionType=${progressionType}`)
        .then(res => res.json())
        .then(progression => {
            const chordNames = progression.chords.map(chord => chord.displayName).join(" - ");
            document.getElementById('result').innerHTML = `<p>${chordNames}</p>`;
            // displayOnPiano(progression);
        });
}

function displayOnPiano(noteCollection){
    const pianoKeys = document.querySelectorAll('ul.piano span');
    const pianoKeyIds = Array.from(pianoKeys).map(pianoKey => pianoKey.id);
    refreshKeys(pianoKeys);
    let noteArray = [];
    noteCollection.notes.forEach(key => {noteArray.push(key.name)});
    for (let i = 0; i < pianoKeyIds.length; i++) {
        let noteName = pianoKeyIds[i].replace(/[0-9]+$/, "")
        if (noteArray.includes(noteName)){
            pianoKeys[i].classList.add("active-note");
        }
    }
}

function refreshKeys(pianoKeys){
    for (let i = 0; i < pianoKeys.length; i++) {
        pianoKeys[i].classList.remove("active-note")
        if(pianoKeys[i].classList.contains("white-key")){
            pianoKeys[i].style.background = "linear-gradient(180deg, #fefefe 0%, #e8e8e8 100%)";
        }
        else{
            pianoKeys[i].style.background = "linear-gradient(180deg, #1a1a1a 0%, #000000 100%)";
        }
    }
}

function drawPiano(){
    const pianoContainer = document.getElementById("piano-container");
    pianoContainer.innerHTML = `
    <!-- Piano Keyboard -->
        <div class="piano-wrapper">
            <ul class="piano">
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/C3.wav')" class="white-key" id="C3"></span>
                    <span onclick="playNote('audiofiles/notes/Db3.wav')" class="black-key" id="Db3"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/D3.wav')" class="white-key" id="D3"></span>
                    <span onclick="playNote('audiofiles/notes/Eb3.wav')" class="black-key" id="Eb3"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/E3.wav')" class="white-key" id="E3"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/F3.wav')" class="white-key" id="F3"></span>
                    <span onclick="playNote('audiofiles/notes/Gb3.wav')" class="black-key" id="Gb3"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/G3.wav')" class="white-key" id="G3"></span>
                    <span onclick="playNote('audiofiles/notes/Ab3.wav')" class="black-key" id="Ab3"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/A3.wav')" class="white-key" id="A3"></span>
                    <span onclick="playNote('audiofiles/notes/Bb3.wav')" class="black-key" id="Bb3"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/B3.wav')" class="white-key" id="B3"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/C4.wav')" class="white-key" id="C4"></span>
                    <span onclick="playNote('audiofiles/notes/Db4.wav')" class="black-key" id="Db4"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/D4.wav')" class="white-key" id="D4"></span>
                    <span onclick="playNote('audiofiles/notes/Eb4.wav')" class="black-key" id="Eb4"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/E4.wav')" class="white-key" id="E4"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/F4.wav')" class="white-key" id="F4"></span>
                    <span onclick="playNote('audiofiles/notes/Gb4.wav')" class="black-key" id="Gb4"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/G4.wav')" class="white-key" id="G4"></span>
                    <span onclick="playNote('audiofiles/notes/Ab4.wav')" class="black-key" id="Ab4"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/A4.wav')" class="white-key" id="A4"></span>
                    <span onclick="playNote('audiofiles/notes/Bb4.wav')" class="black-key" id="Bb4"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/B4.wav')" class="white-key" id="B4"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/C5.wav')" class="white-key" id="C5"></span>
                    <span onclick="playNote('audiofiles/notes/Db5.wav')" class="black-key" id="Db5"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/D5.wav')" class="white-key" id="D5"></span>
                    <span onclick="playNote('audiofiles/notes/Eb5.wav')" class="black-key" id="Eb5"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/E5.wav')" class="white-key" id="E5"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/F5.wav')" class="white-key" id="F5"></span>
                    <span onclick="playNote('audiofiles/notes/Gb5.wav')" class="black-key" id="Gb5"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/G5.wav')" class="white-key" id="G5"></span>
                    <span onclick="playNote('audiofiles/notes/Ab5.wav')" class="black-key" id="Ab5"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/A5.wav')" class="white-key" id="A5"></span>
                    <span onclick="playNote('audiofiles/notes/Bb5.wav')" class="black-key" id="Bb5"></span>
                </li>
                <li class="key">
                    <span onclick="playNote('audiofiles/notes/B5.wav')" class="white-key" id="B5"></span>
                </li>
            </ul>
        </div>
   `
}