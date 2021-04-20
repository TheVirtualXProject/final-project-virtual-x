
let button = document.querySelector(".add-challenge-button");
let modalBox = document.querySelector(".modal-add-challenge");
let theFile = document.querySelector(".file");
let currentFile;
let reader = new FileReader();
let blob;

button.addEventListener("click", () => {
    modalBox.style.display = "block";
});

let closeModal = document.querySelector(".close");

closeModal.addEventListener("click", () => {
    let modalBox = document.querySelector(".modal-add-challenge");
    modalBox.style.display = "none";
});


reader.addEventListener("load", (event) => {
    blob = event.target.result;
   
});

theFile.onchange = function() {
    currentFile = theFile.files[0];
}


let f = document.querySelector(".add-challenge-form");
f.addEventListener("submit", (event) => {
    event.preventDefault();
    let ff = event.currentTarget;
    let inputs = ff.querySelectorAll('input');
    let request = new XMLHttpRequest();
    let formData = new FormData();
    inputs.forEach(input => {
        if(input.files) {

        }
        else {
            formData.append(input.name, input.value);
        }

    });
    let textarea = document.querySelector("textarea");
    formData.append(textarea.name, textarea.value);


    if(currentFile) { 
        reader.readAsDataURL(currentFile);
    }
    else {
        blob = "";
    }
    
    


    setTimeout(() => {

        formData.append("img", blob.toString());
        request.open(ff.method, ff.action);
        request.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
        request.send(formData);
    
        request.onload = function(e) {
            window.location.href = request.response;
        }
    }, 250);
    





})