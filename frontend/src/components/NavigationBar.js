import React from "react";

function NavigationBar({onEventsClick, onTasksClick}) {
    return (
        <div
            style={{
                width: "100%",
                height: "100%",
                backgroundColor: "#f0f0f0",
                padding: "20px",
            }}
        >

            <div style={{marginBottom: "20px", textAlign: "center"}}>
                <div
                    style={{
                        width: "100px",
                        height: "100px",
                        margin: "0 auto",
                        borderRadius: "50%",
                        overflow: "hidden",
                        border: "2px solid #4b9da6", // Viền ngoài cho hình ảnh (tuỳ chọn)
                    }}
                >
                    <img
                        src="https://via.placeholder.com/100"
                        alt="User Avatar"
                        style={{
                            width: "100%",
                            height: "100%",
                            objectFit: "cover", // Đảm bảo hình ảnh phù hợp kích thước
                        }}
                    />
                </div>
                <h3 style={{ marginTop: "10px" }}>User Name</h3>
                <p>user@example.com</p>
            </div>
            <button
                onClick={onEventsClick}
                style={{
                    display: "block",
                    marginBottom: "20px",
                    backgroundColor: "#4b9da6",
                    color: "#fff0db",
                    fontWeight: "bold",
                    padding: "10px",
                    border: "none",
                    cursor: "pointer",
                }}
            >
                Events
            </button>
            <button
                onClick={onTasksClick}
                style={{
                    display: "block",
                    marginBottom: "20px",
                    backgroundColor: "#4b9da6",
                    color: "#fff0db",
                    fontWeight: "bold",
                    padding: "10px",
                    border: "none",
                    cursor: "pointer",
                }}
            >
                Tasks
            </button>

        </div>
    );
}

export default NavigationBar;
