import React from "react";

        function NavigationBar() {
        return (
<div
      style={{
              width: "250px",
              position: "fixed",
              height: "100%",
              backgroundColor: "#f0f0f0",
              padding: "20px",
              }}
              >
              {/* Thông tin người dùng */}
<div style={{ marginBottom: "20px", textAlign: "center" }}>
<img
          src="https://via.placeholder.com/100"
                  alt="User Avatar"
                  style={{ borderRadius: "50%" }}
                  />
<h3>User Name</h3>
<p>user@example.com</p>
</div>

        {/* Các nút */}
<button style={{ display: "block", marginBottom: "10px" }}>Events</button>
<button style={{ display: "block", marginBottom: "10px" }}>Tasks</button>
</div>
        );
        }

        export default NavigationBar;
