import { useState } from 'react';

export default function Player({ initalName, symbol, isActive }) {
    const [isEditing, setIsEditing] = useState(false);
    const [playerName, setPlayerName] = useState(initalName);

    function handleEditClick() {
        setIsEditing((editing) => !editing);
    }

    function handleChange(event) {
        setPlayerName(event.target.value);
    }

    return (
        <li className={isActive ? 'active' : undefined}>
            <span className='player'>
                {isEditing ?
                    <input type="text" required onChange={handleChange} value={playerName} /> :
                    <span className='player-name'>{playerName}</span>
                }
                <span className='player-symbol'> {symbol}</span>
            </span>
            {isEditing ?
                <button onClick={handleEditClick} >Save</button> :
                <button onClick={handleEditClick} >Edit</button>

            }
        </li>
    );
}