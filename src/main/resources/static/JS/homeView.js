let main = document.querySelector(".cards");
let colorClasses = ["light-blue", "dark-blue", "yellow" , "red", "purple"];
let smallPictures = ["/images/home-image-square-artist-vector.png", 
"/images/home-image-square-basketball-players-vector.png",
"/images/home-image-square-dance-vector.png",
"/images/home-image-square-musician-vector.png",
"/images/home-image-square-online-party-vector.png",
"/images/home-image-square-soccer-vector.png"];
let largePictures = ["/images/home-image-rectangle-chat-vector.png",
"/images/home-image-rectangle-coffee-break-vector.png",
"/images/home-image-rectangle-connect-vector.png",
"/images/home-image-rectangle-music-band.png",
"/images/home-image-rectangle-walk-dog-vector.png"];
let lastSmallPicture = "";
let lastLargePicture = "";
let colorCounter = 0;
let pictureCounter = 0;


function createChallengeCard(challenge) {
    if(!challenge.public && challenge.joinedPlayers >= challenge.maxPlayers) {
        return;
    }
    let title = document.createElement("h2");
    title.classList.add("title");
    let challengeLink = document.createElement("a");
    challengeLink.href = "/challenge/" + challenge.id;
    challengeLink.appendChild(title);

    title.innerText = challenge.title;
    let challengeDiv = document.createElement("div");
    challengeDiv.classList.add("activity-card");
    challengeDiv = chooseCardColor(challengeDiv);
    let host = document.createElement("h3");
    host.classList.add("host");
    host.innerText = `Author: ${challenge.creatorName}`;
    let size = document.createElement("h4");
    size.classList.add("size");
    if(challenge.public) {
        size.innerText = `Size: ${challenge.joinedPlayers}`;
    }
    else {
        size.innerText = `Size: ${challenge.joinedPlayers}/${challenge.maxPlayers}`;
    }
    
    let duration = document.createElement("h4");
    duration.classList.add("duration");
    duration.innerText = `Duration: ${challenge.duration}`;
    let description = document.createElement("p");
    description.classList.add("description");
    let challengeDesc = trimChallengeLength(challenge.description);
    description.innerText = challengeDesc;
    let join = document.createElement("button");
    join.classList.add("join-button");
    join.innerText = "Join";
    //remember to add event listeners to these buttons at this part later

    challengeDiv.appendChild(challengeLink);
    challengeDiv.appendChild(host);
    challengeDiv.appendChild(size);
    challengeDiv.appendChild(duration);
    challengeDiv.appendChild(description);
    challengeDiv.appendChild(join);
    main.appendChild(challengeDiv);

    checkForPictureAdd();
    checkForJoinDisable(join, challenge);

    join.addEventListener("click", ()=> {
        fetch("/challenge/" + challenge.id + "/join-challenge", {
            method:"POST"
        })
        .then(response => response.text())
        .then(url => window.location.href = url)

    });
    

}


function createChatroomCard(chatroom) {
    if(chatroom.currentSize >= chatroom.maxSize) {
        return;
    }
    let chatroomDiv = document.createElement("div");
    chatroomDiv.classList.add("activity-card");
    chatroomDiv = chooseCardColor(chatroomDiv);
    let title = document.createElement("h2");
    title.classList.add("title");
    title.innerText = chatroom.channelName;
    let host = document.createElement("h3");
    host.classList.add("host");
    host.innerText = `Host: ${chatroom.author}`;
    let size = document.createElement("h4");
    size.classList.add("size");
    size.innerText = "Size: " + chatroom.currentSize + "/" + chatroom.maxSize;
    let chatDesc = document.createElement("p");
    chatDesc.classList.add("description");
    chatDesc.innerText = chatroom.description;
    let join = document.createElement("button");
    join.classList.add("join-button");
    join.innerText = "Join";


    chatroomDiv.appendChild(title);
    chatroomDiv.appendChild(host);
    chatroomDiv.appendChild(size);
    chatroomDiv.appendChild(chatDesc);
    chatroomDiv.appendChild(join);
    main.appendChild(chatroomDiv);

    checkForPictureAdd();

    join.addEventListener("click", () => {
        fetch("/chat/" + chatroom.id + "/join-chatroom", {
            method: "POST",
        }).then(response => response.text())
        .then(url => window.location.href = url);
    });


}

function createGameCard(game) {
    if(game.joinedPlayers >= game.maxPlayers) {
        return;
    }
    let gameDiv = document.createElement("div");
    gameDiv.classList.add("activity-card");
    gameDiv = chooseCardColor(gameDiv);
    let title = document.createElement("h2");
    title.classList.add("title");
    title.innerText = game.title;
    let host = document.createElement("h3");
    host.classList.add("host");
    host.innerText = `Host: ${game.creatorName}`;
    let size = document.createElement("h4");
    size.classList.add("size");
    size.innerText = "Size: " + game.joinedPlayers + "/" + game.maxPlayers;
    let gameDesc = document.createElement("p");
    gameDesc.classList.add("description");
    gameDesc.innerText = "Come play this fun game!";
    let join = document.createElement("button");
    join.classList.add("join-button");
    join.innerText = "Join";


    gameDiv.appendChild(title);
    gameDiv.appendChild(host)
    gameDiv.appendChild(size);
    gameDiv.appendChild(gameDesc)
    gameDiv.appendChild(join);
    main.appendChild(gameDiv);

    checkForPictureAdd();

    join.addEventListener("click", () => {
        fetch("/game/" + game.id + "/join-game", {
            method:"POST",
        }).then(response => response.text())
        .then(url => window.location.href = url);
    });
}

async function checkForJoinDisable(join, challenge){
    let isAccountThere = await fetch("/api/challenges/" + challenge.id + "/check-users", {
        method: "GET"
    }).then(response => response.json());

    if(isAccountThere) {
        join.disabled = true;
        join.innerText = "Already Joined";
    }
}

function trimChallengeLength(desc) {
    if(desc.length > 100) {
        desc = desc.substring(0, 100);
        desc += "...";
    }
    return desc;
}

function chooseCardColor(challengeCard) {

    let selectedColor = colorClasses[colorCounter];
    challengeCard.classList.add(selectedColor);
    colorCounter++;
    if(colorCounter >= colorClasses.length) {
        colorCounter = 0;
    }

    return challengeCard;
}

function checkForPictureAdd() {
    let pictureCardDiv = document.createElement("div");
    pictureCardDiv.classList.add("activity-card");
    if(pictureCounter === 2 || pictureCounter === 4) {
        let chosenPicture = chooseRandomPicture(smallPictures);
        while(chosenPicture === lastSmallPicture) {
            chosenPicture = chooseRandomPicture(smallPictures);
        }
        lastSmallPicture = chosenPicture;
        pictureCounter++;
        pictureCardDiv.classList.add("img-deco-square");
        let img = document.createElement("img");
        img.src = chosenPicture;
        img.classList.add("home-square-img");
        pictureCardDiv.appendChild(img);
        main.appendChild(pictureCardDiv);


    }
    else if(pictureCounter === 3 || pictureCounter === 9) {
        let chosenPicture = chooseRandomPicture(largePictures);
        while(chosenPicture === lastLargePicture) {
            chosenPicture = chooseRandomPicture(largePictures);
        }
        lastLargePicture = chosenPicture;
        pictureCounter++;
        pictureCardDiv.classList.add("img-deco-rectangle");
        let img = document.createElement("img");
        img.src = chosenPicture;
        img.classList.add("home-rectangle-img");
        pictureCardDiv.appendChild(img);
        main.appendChild(pictureCardDiv);
    }
    else if(pictureCounter === 10) {
        pictureCounter = 1;
    }
    else {
        pictureCounter++;
    }
}

function chooseRandomPicture(pictureArray) {
    let index = parseInt(Math.random()* pictureArray.length);
    return pictureArray[index];

}



async function checkForChallenges() {
    let challengeJson = await fetch("/api/challenges",{
        method: "GET",
    }).then(response => response.json());

    return challengeJson;
}

async function checkForChatrooms() {
    let chatroomJson = await fetch("/api/chatrooms", {
        method: "GET",
    }).then(response => response.json());
    return chatroomJson;
}

async function checkForGames() {
    let gameJson = await fetch("/api/games", {
        method:"GET",
    }).then(response => response.json());
    return gameJson;
}

async function processJsonValues() {
    let challengeJson =  await checkForChallenges();
    let chatroomJson = await checkForChatrooms();
    let gameJson = await checkForGames();
    //code for games and chat rooms goes here
    let index = 0;
    while(checkIndexToLength(challengeJson, index) || checkIndexToLength(chatroomJson, index) || checkIndexToLength(gameJson, index)) {
    // add the others here so that the generation spreads them out on the page by 3
        if(checkIndexToLength(challengeJson, index)) {
            createChallengeCard(challengeJson[index]);
        }
        if(checkIndexToLength(chatroomJson, index)) {
            createChatroomCard(chatroomJson[index]);
        }
        if(checkIndexToLength(gameJson, index)) {
            createGameCard(gameJson[index]);
        }
        index++;
    }

}

function clearChildren(element) {
    while(element.firstChild) {
            element.removeChild(element.lastChild);
    }
}

async function sortAlgoForSortingTab() {
    const openChallenge = document.querySelector(".open-challenges");
    let openChallengesStuff = await checkForChallenges();
    openChallenge.addEventListener("click", (event) => {
        event.preventDefault();
        let cards = document.querySelector(".cards");
        clearChildren(cards);
        pictureCounter = 0;
        openChallengesStuff.forEach(element => {
            createChallengeCard(element);

        });
    });

    const openGames = document.querySelector(".open-games");
    let openGamesStuff = await checkForGames();
    openGames.addEventListener("click", (event) => {
        event.preventDefault();
        let cards = document.querySelector(".cards");
        clearChildren(cards);
        pictureCounter = 0;
        openGamesStuff.forEach(element => {
            createGameCard(element);
        })
    });

    const openChatrooms = document.querySelector(".open-chatrooms");
    let openChatroomsStuff = await checkForChatrooms();
    openChatrooms.addEventListener("click", (event) => {
        event.preventDefault();
        let cards = document.querySelector(".cards");
        clearChildren(cards);
        pictureCounter = 0;

        openChatroomsStuff.forEach(chatroom => {
            createChatroomCard(chatroom)
        });

    });

    const allSort = document.querySelector(".all");
    allSort.addEventListener("click", (event) => {
        event.preventDefault();
        pictureCounter = 0;
        let cards = document.querySelector(".cards");
        clearChildren(cards);
        processJsonValues();
    });
    

}


function checkIndexToLength(arr, index) {
    return arr.length > index;
}

processJsonValues();
sortAlgoForSortingTab();


