import Player from './components/Player';
import GameBoard from './components/GameBoard';
import GameOver from "./components/GameOver";
import Log from './components/Log';

import { WINNING_COMBINATIONS } from './winning-combinations.js';

import { useState } from 'react';

const INITAL_PLAYERES = {
    X: 'Player 1',
    O: 'Player 2'
}

const INITAL_GAME_BOARD = [
    [null, null, null],
    [null, null, null],
    [null, null, null]
];

function deriveActivePlayer(gameTurns) {
    let currentPlayer = 'X';

    if (gameTurns.length > 0 && gameTurns[0].player === 'X') {
        currentPlayer = 'O';
    }
    return currentPlayer;
}

function populateGameBoard(turns) {
    let gameBoard = [...INITAL_GAME_BOARD.map((row) => [...row])];

    for (const turn of turns) {
        const { square, player } = turn;
        const { row, col } = square;

        gameBoard[row][col] = player;
    }
    return gameBoard;
}

function deriveWinner(currentGameBoard, gameTurns, players) {
    let winner = null;
    if (gameTurns.length > 4) {
        for (const combination of WINNING_COMBINATIONS) {
            const firstSquareSymbol = currentGameBoard[combination[0].row][combination[0].column];
            const secondSquareSymbol = currentGameBoard[combination[1].row][combination[1].column];
            const thridSquareSymbol = currentGameBoard[combination[2].row][combination[2].column];

            if (firstSquareSymbol
                && firstSquareSymbol === secondSquareSymbol
                && firstSquareSymbol === thridSquareSymbol) {
                winner = players[firstSquareSymbol];
            }
        }
    }

    return winner;
}

function App() {
    const [players, setPlayers] = useState(INITAL_PLAYERES)
    const [gameTurns, setGameTurns] = useState([]);

    const activePlayer = deriveActivePlayer(gameTurns);
    const currentGameBoard = populateGameBoard(gameTurns);
    const winner = deriveWinner(currentGameBoard, gameTurns,players);
    const hasDraw = !winner && (gameTurns.length ===9)

    function handleSelectSquare(rowIndex, colIndex) {
        setGameTurns(prevTurns => {
            const currentPlayer = deriveActivePlayer(prevTurns);

            const updatedTurns = [
                { square: { row: rowIndex, col: colIndex }, player: currentPlayer },
                ...prevTurns];
            return updatedTurns;
        });
    }
    function handleGameOverClick() {
        setGameTurns([]);
    }
    function handlePlayerNameChange(symbol, newName) {
        setPlayers(prevPlayer => {
            return {
                ...prevPlayer,
                [symbol] : newName
            }
        })
    }

    return (
        <main>
            <div id='game-container'>
                <ol id='players' className='highlight-player'>
                    <Player initalName={players.X} symbol='X' isActive={activePlayer === 'X'} onPlayerNameSave={handlePlayerNameChange} />
                    <Player initalName={players.O} symbol='O' isActive={activePlayer === 'O'} onPlayerNameSave={handlePlayerNameChange} />
                </ol>
                {(winner || hasDraw) && <GameOver winner={winner} onRematchClick={handleGameOverClick} />}
                <GameBoard onSelectSquare={handleSelectSquare} board={currentGameBoard} />
            </div>
            <Log turns={gameTurns} />
        </main>
    );
}

export default App;
