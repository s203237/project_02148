import React from "react";

const TaskList = ({ date }) => {

    // Mock job data (can be fetched from API or props)
    const tasks = [
        { id: 1, title: "Write report", time: "10:00 AM", date: "2025-01-22" },
        { id: 2, title: "Team meeting", time: "2:00 PM", date: "2025-01-23" },
        { id: 3, title: "Submit project", time: "4:00 PM", date: "2025-01-22" },
    ];

    // Filter jobs by date
    const tasksForDate = tasks.filter(
        (task) => new Date(task.date).toDateString() === date.toDateString()
    );

    return (
        <ul>
            {tasksForDate.length > 0 ? (
                tasksForDate.map((task) => (
                    <li key={task.id}>
                        <strong>{task.title}</strong> at {task.time}
                    </li>
                ))
            ) : (
                <li>No tasks</li>
            )}
        </ul>
    );
};

export default TaskList;
