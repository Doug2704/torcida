const GAME_DURATION_MINUTES = 135;

async function carregarJogos() {

    try {

        const resposta = await fetch("/api/v1/matches");

        if (!resposta.ok) {
            throw new Error("Erro ao buscar jogos");
        }

        const dados = await resposta.json();

        const tbody = document.querySelector("#fixture tbody");

        if (!tbody) return;

        tbody.innerHTML = "";

        const jogos = dados.matches;

        const agora = new Date();

        const futuros = jogos.filter(jogo => {

            const inicio = new Date(jogo.utcDate);

            const fim = new Date(inicio.getTime() + GAME_DURATION_MINUTES * 60000);

            return agora < fim;

        });

        futuros.sort((a, b) => new Date(a.utcDate) - new Date(b.utcDate));

        const proximosCinco = futuros.slice(0, 5);

        proximosCinco.forEach((jogo, i) => {

            const data = new Date(jogo.utcDate);

            const dataBR = data.toLocaleDateString("pt-BR");

            const horaBR = data.toLocaleTimeString("pt-BR", {
                hour: "2-digit",
                minute: "2-digit"
            });

            const casa = jogo.homeTeam.name;
            const fora = jogo.awayTeam.name;
            const competicao = jogo.competition.name;

            const tr = document.createElement("tr");

            if (i === 0) {
                tr.classList.add("next-game");
            }

            tr.innerHTML = `
                <td>${dataBR}</td>
                <td>${casa} x ${fora}</td>
                <td>${competicao}</td>
                <td>${horaBR}</td>
            `;

            tbody.appendChild(tr);

        });

    } catch (erro) {
        console.error("Erro ao carregar jogos:", erro);
    }
}

document.addEventListener("DOMContentLoaded", () => {
    carregarJogos();
    setInterval(carregarJogos, 60000);
});