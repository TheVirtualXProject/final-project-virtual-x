let game = document.querySelector(".novelgames_cloudgame");
let gameId = window.location.href.substring(window.location.href.lastIndexOf("/") + 1);




async function retrieveGameData() {
    let gameData = await fetch("/api/games/" + gameId, {
        method:"GET",
    }).then(response => response.json());
    let playerGameHash = await fetch("/api/games/" + gameId + "/player", {
        method: "GET",
    }.then(response => response.json()));
}