function fetchNote() {
    const name = document.getElementById('name-input').value;
    fetch(`/note?name=${name}`)

        .then(res => res.json())
        .then(note => {
            document.getElementById('result').innerHTML = `
                    <p>Note Name: ${note.name}</p>
                `;
        });
}

function playNote(audioFile) {
    const note = new Audio(audioFile);
    note.currentTime = 0;
    note.play();
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