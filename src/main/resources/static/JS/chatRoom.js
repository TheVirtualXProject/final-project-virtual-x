let addChatroom = document.querySelector(".add-chatroom-button");
let closeModal = document.querySelector(".close");
let modal = document.querySelector(".modal-add-chatroom")


addChatroom.addEventListener("click", () => {  
    modal.style.display = "block";

});


closeModal.addEventListener("click", () => {
    modal.style.display = "none";
});


async function retrieveAllChatrooms() {
    let chatroomJson = await fetch("/api/chatrooms", {
        method:"GET",
    }).then(response => response.json());

    return chatroomJson;
}



async function displayAllChatrooms() {
    let chatroomJson = await retrieveAllChatrooms();

    let currentChatrooms = document.querySelector(".current-chatrooms-list");

    chatroomJson.forEach(chatroom => {
        if(chatroom.currentSize < chatroom.maxSize) {
            let listItem = document.createElement("li");
            listItem.innerText = chatroom.channelName;
            listItem.classList.add("chatroom-link");
            listItem.style.cursor = "pointer";
    
            listItem.addEventListener("click", () => {
                fetch("/chat/" + chatroom.id + "/join-chatroom", {
                    method:"POST",

                }).then(response => response.text())
                .then(url => window.location.href = url);
            });
            currentChatrooms.appendChild(listItem);
        }
       

        
    });
    
}

displayAllChatrooms();