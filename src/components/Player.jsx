import { useState } from 'react';

export default function Player({ initalName, symbol, isActive, onPlayerNameSave }) {
    const [isEditing, setIsEditing] = useState(false);
    const [playerName, setPlayerName] = useState(initalName);

    function handleEditClick() {
        setIsEditing(true);
    }

    function handleSaveClick() {
        setIsEditing(false);
        onPlayerNameSave(symbol, playerName)
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
                <button onClick={handleSaveClick} >Save</button> :
                <button onClick={handleEditClick} >Edit</button>

            }
        </li>
    );
}