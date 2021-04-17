let addChatroom = document.querySelector(".add-chatroom-button");
let closeModal = document.querySelector(".close");
let modal = document.querySelector(".modal-add-chatroom")


addChatroom.addEventListener("click", () => {  
    modal.style.display = "block";

});


closeModal.addEventListener("click", () => {
    modal.style.display = "none";
});