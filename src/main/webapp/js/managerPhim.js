function load(i) {
    let input = document.querySelector('.file' + i);
    let textarea = document.querySelector('.area' + i);
    let files = input.files;

    if (files.length == 0) return;

    const file = files[0];

    let reader = new FileReader();

    reader.onload = (e) => {
        const file = e.target.result;
        const lines = file.split(/\r\n|\n/);
        textarea.value = lines.join('\n');
        change(textarea.value, i);
    };

    reader.onerror = (e) => alert(e.target.error.name);

    reader.readAsDataURL(file);
}

function change(name, u) {
    var img = document.getElementById("img" + u);
    img.src = name;
    img.style.width = 200 + "px";
    img.style.height = 200 + "px";
}
