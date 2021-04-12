let main = document.querySelector("._main");
let colorClasses = ["light-blue", "dark-blue", "yellow" , "red", "purple"];
let smallPictures = ["/images/home-image-square-chat.jpg", 
"/images/home-image-square-darts.jpg",
"/images/home-image-square-pool.jpg",
"/images/home-image-square-walkDog.jpg",
"/images/home-image-square-wordGame.jpg"];
let largePictures = ["/images/home-image-rectangle-chess.jpg",
"/images/home-image-rectangle-drink.jpg",
"/images/home-image-rectangle-eatSign.jpg",
"/images/home-image-rectangle-hello.jpg",
"/images/home-image-rectangle-pushUp.jpg",
"/images/home-image-rectangle-salad.jpg"];
let lastSmallPicture = "";
let lastLargePicture = "";
let colorCounter = 0;
let pictureCounter = 0;

function createChallengeCard(challenge) {
    let challengeDiv = document.createElement("div");
    challengeDiv.classList.add("activity-card");
    challengeDiv = chooseCardColor(challengeDiv);
    let host = document.createElement("h3");
    host.classList.add("host");
    host.innerText = `Author: ${challenge.account.realName}`;
    let size = document.createElement("h4");
    size.classList.add("size");
    size.innerText = `Size: ${challenge.joinedPlayers}/${challenge.maxPlayers}`;
    let duration = document.createElement("h4");
    duration.classList.add("duration");
    duration.innerText = `Duration: Sample Duration`;
    let description = document.createElement("p");
    description.classList.add("description");
    description.innerText = challenge.description;
    let join = document.createElement("button");
    join.classList.add("join-button");
    join.innerText = "Join";
    //remember to add event listeners to these buttons at this part later

    challengeDiv.appendChild(host);
    challengeDiv.appendChild(size);
    challengeDiv.appendChild(duration);
    challengeDiv.appendChild(description);
    challengeDiv.appendChild(join);
    main.appendChild(challengeDiv);

    checkForPictureAdd();



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


let something = {
    account: {
        realName: "BOB"

    },
    maxPlayers: 5,
    joinedPlayers: 1,
    description: "SALKDJASLKDLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL"

};

createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
createChallengeCard(something);
