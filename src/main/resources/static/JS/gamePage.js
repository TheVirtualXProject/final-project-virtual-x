let popularGamesList = document.querySelector(".popular-games-list");


async function retrievePopularGames() {
    let popularGames = await fetch("/api/games/popular", {
        method:"GET",
    }).then(response => response.json());

    return popularGames;
}

async function showPopularGames() {
    let popularGames = await retrievePopularGames();

    for(let i = 0; i < 10;i++) {
        let listItem = document.createElement("li");
        let anchor = document.createElement("a");
        anchor.href = "/game/" + popularGames[i].id + "/create-game";
        anchor.innerText = popularGames[i].name;
        listItem.appendChild(anchor);
        popularGamesList.appendChild(listItem);
        console.log(popularGames[i])
    }
}

showPopularGames();