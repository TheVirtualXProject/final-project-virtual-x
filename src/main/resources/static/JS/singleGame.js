let game = document.querySelector(".novelgames_cloudgame");
let gameId = window.location.href.substring(window.location.href.lastIndexOf("/") + 1);




async function retrieveGameData() {
    let gameData = await fetch("/api/games/" + gameId, {
        method:"GET",
    }).then(response => response.json());
    let playerGameHash = await fetch("/api/games/playerHash", {
        method: "GET",
    }).then(response => response.json());


    setGameData(gameData, playerGameHash)
    createNovelGamesScript();
}

function setGameData(gameData, playerGameHash) {
    game.setAttribute("data-game-short-name", gameData.shortName);
    game.setAttribute("data-member-id", gameData.memberId);
    game.setAttribute("data-player-id", playerGameHash.playerId);
    game.setAttribute("data-player-name", playerGameHash.playerName);
    game.setAttribute("data-player-hash", playerGameHash.hash);
    
    
}


function createNovelGamesScript() {
    let script = document.createElement("script");
    script.src = "//license.novelgames.com/games/game.js"
    document.querySelector("body").appendChild(script);

}

retrieveGameData();
