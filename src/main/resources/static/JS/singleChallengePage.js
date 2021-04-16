let challengeUrl = window.location.href;
let challengeId = challengeUrl.substring(challengeUrl.lastIndexOf("/") + 1);
let joinButton = document.querySelector(".join-button");
let challengeData;
let challengeImage = document.querySelector(".single-challenge-img");
let commentFormDiv = document.querySelector("._singleChallengeCommentForm");
let commentForm = document.querySelector(".add-comment-form");
let reader = new FileReader();
let commentBlob;



async function checkForDisableJoin() {
    let isAccountThere = await checkIfAccountIsInChallenge();

    joinButton.disabled = isAccountThere;
    if(isAccountThere) {
        joinButton.innerHTML = "Already Joined";
    }
    else {
        commentFormDiv.style.visibility = "hidden";

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

// function purgeUselessImages() {
//     let images = document.querySelectorAll("img");
//     images.forEach(curImage => {
//         curImage.onerror = function() {
//             curImage.parentElement.removeChild(curImage);
//         }
//     });
// }



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

reader.addEventListener("load", (event) => {
    commentBlob = event.target.result;
});

commentForm.addEventListener("submit", (event)=> {
    event.preventDefault();
    let ff = event.currentTarget;
    let commentTextArea = ff.querySelector(".commentTextArea");
    let request = new XMLHttpRequest();
    let formData = new FormData();
    let commentMedia = document.querySelector(".fileInput");
    

    formData.append(commentTextArea.name, commentTextArea.value);
    if(commentMedia.files[0]) {
        reader.readAsDataURL(commentMedia.files[0]);
    }
    
    setTimeout(() => {
        if(commentMedia.files[0]) {
            formData.append("addMedia", commentBlob.toString());
        }
        request.open(ff.method, "/challenge/" + challengeId +"/addComment");
        request.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
        request.send(formData);

        request.onload = function(e) {
            window.location.reload();
        }
    }, 250);

}) 




fetchChallengeData();

