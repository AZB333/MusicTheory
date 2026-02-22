function fetchNote() {
    const name = document.getElementById('name-input').value;
    const octave = document.getElementById('octave-input').value;

    fetch(`/note?name=${name}&octave=${octave}`)
        .then(res => res.json())
        .then(note => {
            document.getElementById('result').innerHTML = `
                    <p>Note Name: ${note.name}</p>
                    <p>Octave: ${note.octave}</p>
                `;
        });
}


function playAudio(){
    console.log("pressed");
    const audio = new Audio('/audiofiles/vine-boom-sound-effect(chosic.com).mp3');
    audio.play();
}