let challengeUrl = window.location.href;
let challengeId = challengeUrl.substring(challengeUrl.lastIndexOf("/") + 1);
let joinButton = document.querySelector(".join-button");
let challengeData;
let challengeImage = document.querySelector(".single-challenge-img");
let commentForm = document.querySelector("._singleChallengeCommentForm");



async function checkForDisableJoin() {
    let isAccountThere = await checkIfAccountIsInChallenge();

    joinButton.disabled = isAccountThere;
    if(isAccountThere) {
        joinButton.innerHTML = "Already Joined";
    }
    else {
        commentForm.style.visibility = "hidden";

    }
    
    checkForIfPublic()

    
    if(challengeData.public || challengeData.joinedPlayers < challengeData.maxPlayers) {
        joinButton.addEventListener("click", () => {
            fetch("/challenge/" + challengeId + "/join-challenge", {
                method:"POST"
            })
            window.location.reload();

        });
    } else {
        joinButton.disabled = true;
    }
    

}

function checkForIfPublic() {
    let size = document.querySelector(".size");
    if(challengeData.public) {

        size.innerHTML = "Size: " + challengeData.joinedPlayers;
    }
    else {
        size.innerHTML = "Size: " + challengeData.joinedPlayers + " (max: " + challengeData.maxPlayers + ")";
    }
}

async function checkIfAccountIsInChallenge() {
    let isAccountThere = await fetch("/api/challenges/" + challengeId + "/check-users", {
        method: "GET"
    }).then(response => response.json());
    return isAccountThere;
}



async function fetchChallengeData() {
    challengeData = await fetch("/api/challenges/" + challengeId, {
        method:"GET"
    }).then(response => response.json());
    setImage(challengeData.image);
    checkForDisableJoin();
}

function setImage(blob) {
    challengeImage.src = blob;
}


fetchChallengeData();
