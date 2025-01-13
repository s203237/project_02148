import React from "react";

const TodoList = ({ date }) => {
    return (
        <ul>
            <li>Task 1 - {date.toDateString()}</li>
            <li>Task 2 - {date.toDateString()}</li>
        </ul>
    );
};

export default TodoList;
