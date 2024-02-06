const initalGameBoard = [
    [null, null, null],
    [null, null, null],
    [null, null, null]
];


export default function GameBoard({ onSelectSquare, board }) {

    return (<ol id='game-board'>
        {board.map((row, rowIndex) => (
            <li key={rowIndex}>
                <ol>
                    {row.map((tileSymbol, colIndex) => (
                        <li key={colIndex}>
                            <button onClick={() => onSelectSquare(rowIndex, colIndex)} disabled={tileSymbol} >{tileSymbol}</button>
                        </li>
                    ))}
                </ol>
            </li>
        ))}
    </ol>
    );
}