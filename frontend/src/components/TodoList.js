import React, { useState } from "react";

const TodoList = () => {
    const [todos, setTodos] = useState([
        { title: "Todo 1", completed: false },
        { title: "Todo 2", completed: false },
        { title: "Todo 3", completed: false },
    ]);
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [newTask, setNewTask] = useState("");

    // Thêm task mới
    const handleAddTask = () => {
        if (newTask.trim()) {
            setTodos([...todos, { title: newTask, completed: false }]);
            setIsModalOpen(false);
            setNewTask("");
        } else {
            alert("Please enter a task title!");
        }
    };

    // Toggle trạng thái hoàn thành task
    const toggleTaskCompletion = (index) => {
        setTodos(
            todos.map((todo, i) =>
                i === index ? { ...todo, completed: !todo.completed } : todo
            )
        );
    };

    // Xóa task
    const handleDeleteTask = (index) => {
        setTodos(todos.filter((_, i) => i !== index));
    };

    return (
        <div>
            <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center" }}>
                <h2>Todo List</h2>
                <button
                    onClick={() => setIsModalOpen(true)}
                    style={{
                        width: "40px",
                        height: "40px",
                        borderRadius: "50%",
                        backgroundColor: "#568203",
                        color: "white",
                        fontSize: "30px",
                        fontWeight: "bold",
                        border: "none",
                        cursor: "pointer",
                        display: "flex",
                        alignItems: "center",
                        justifyContent: "center",
                        boxShadow: "0px 4px 6px rgba(0, 0, 0, 0.1)",
                    }}
                    title="Add Task"
                >
                    +
                </button>
            </div>

            {/* Modal thêm task */}
            {isModalOpen && (
                <div
                    style={{
                        position: "fixed",
                        top: "0",
                        left: "0",
                        width: "100vw",
                        height: "100vh",
                        backgroundColor: "rgba(0, 0, 0, 0.5)",
                        display: "flex",
                        justifyContent: "center",
                        alignItems: "center",
                    }}
                >
                    <div
                        style={{
                            backgroundColor: "white",
                            padding: "20px",
                            borderRadius: "8px",
                            width: "400px",
                            boxShadow: "0 4px 8px rgba(0, 0, 0, 0.2)",
                        }}
                    >
                        <h3>Add Task</h3>
                        <input
                            type="text"
                            placeholder="Task title"
                            value={newTask}
                            onChange={(e) => setNewTask(e.target.value)}
                            style={{
                                width: "100%",
                                padding: "10px",
                                marginBottom: "10px",
                                border: "1px solid #ccc",
                                borderRadius: "4px",
                            }}
                        />
                        <div style={{ display: "flex", justifyContent: "flex-end", gap: "10px" }}>
                            <button
                                onClick={() => setIsModalOpen(false)}
                                style={{
                                    backgroundColor: "#ccc",
                                    color: "white",
                                    padding: "10px 15px",
                                    border: "none",
                                    borderRadius: "4px",
                                    cursor: "pointer",
                                }}
                            >
                                Cancel
                            </button>
                            <button
                                onClick={handleAddTask}
                                style={{
                                    backgroundColor: "#4caf50",
                                    color: "white",
                                    padding: "10px 15px",
                                    border: "none",
                                    borderRadius: "4px",
                                    cursor: "pointer",
                                }}
                            >
                                Save
                            </button>
                        </div>
                    </div>
                </div>
            )}

            <ul>
                {todos.map((todo, index) => (
                    <li
                        key={index}
                        style={{
                            display: "flex",
                            alignItems: "center",
                            justifyContent: "space-between",
                            padding: "5px 0",
                        }}
                    >
                        <div style={{ display: "flex", alignItems: "center" }}>
                            <input
                                type="checkbox"
                                checked={todo.completed}
                                onChange={() => toggleTaskCompletion(index)}
                                style={{ marginRight: "10px" }}
                            />
                            <span
                                style={{
                                    textDecoration: todo.completed ? "line-through" : "none",
                                }}
                            >
                                {todo.title}
                            </span>
                        </div>
                        <button
                            onClick={() => handleDeleteTask(index)}
                        >
                            🗑️
                        </button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default TodoList;
