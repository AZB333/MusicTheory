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


function playAudio(){
    console.log("pressed");
    const audio = new Audio('/audiofiles/vine-boom-sound-effect(chosic.com).mp3');
    audio.play();
}

function fetchScale(){
    const root = document.getElementById('root').value;
    const scaleType = document.getElementById('scale-type').value;

    fetch(`/scale?root=${root}&scaleType=${scaleType}`)
        .then(res => res.json())
        .then(scale => {
            const noteNames = scale.notes.map(note => note.name).join('-');
            document.getElementById('result').innerHTML = `<p>${noteNames}</p>`;
        });
}