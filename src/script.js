// Handle Login
document.getElementById("loginForm").addEventListener("submit", function (event) {
    event.preventDefault();

    const username = document.getElementById("username").value.trim().toLowerCase();

    if (username === "admin") {
        loadDashboard("Admin");
    } else if (username === "shelter") {
        loadDashboard("Shelter");
    } else if (username === "adopter") {
        loadDashboard("Adopter");
    } else {
        alert("User not found! Try: admin / shelter / adopter");
    }
});

// Load Dashboard Based on Role
function loadDashboard(role) {
    document.getElementById("loginContainer").style.display = "none";
    document.getElementById("dashboard").style.display = "block";
    document.getElementById("dashboardTitle").innerText = role + " Dashboard";

    const content = document.getElementById("dashboardContent");
    content.innerHTML = "";

    if (role === "Admin") {
        content.innerHTML = `
            <p>Manage users, pet listings, and system settings.</p>
            <button onclick="viewPets()">View All Pets</button>
        `;
    }

    if (role === "Shelter") {
        content.innerHTML = `
            <p>Add pets and manage adoption listings.</p>
            <button onclick="showAddPetForm()">Add Pet</button>
            <button onclick="viewPets()">View Pets</button>
        `;
    }

    if (role === "Adopter") {
        content.innerHTML = `
            <p>Browse pets available for adoption.</p>
            <button onclick="viewPets()">Browse Pets</button>
        `;
    }
}

// Logout
function logout() {
    document.getElementById("loginContainer").style.display = "block";
    document.getElementById("dashboard").style.display = "none";
    document.getElementById("dashboardContent").innerHTML = "";
}

// Fetch Pets from Backend
function viewPets() {
    fetch("pets")
        .then(response => response.json())
        .then(data => {
            const content = document.getElementById("dashboardContent");
            content.innerHTML = "<h3>Pet Listings</h3>";

            if (data.length === 0) {
                content.innerHTML += "<p>No pets available.</p>";
                return;
            }

            data.forEach(pet => {
                content.innerHTML += `
                    <p>
                        <strong>${pet.name}</strong> 
                        (${pet.breed}) - Age: ${pet.age} 
                        | Available: ${pet.isAvailable}
                    </p>
                `;
            });
        })
        .catch(error => {
            alert("Error fetching pets.");
            console.error(error);
        });
}

// Show Add Pet Form (Shelter Role)
function showAddPetForm() {
    const content = document.getElementById("dashboardContent");

    content.innerHTML = `
        <h3>Add New Pet</h3>
        <input type="text" id="petName" placeholder="Pet Name" required>
        <input type="text" id="petBreed" placeholder="Breed" required>
        <input type="number" id="petAge" placeholder="Age" required>
        <select id="petAvailable">
            <option value="true">Available</option>
            <option value="false">Not Available</option>
        </select>
        <br>
        <button onclick="addPet()">Submit</button>
    `;
}

// Send Pet Data to Backend
function addPet() {
    const name = document.getElementById("petName").value;
    const breed = document.getElementById("petBreed").value;
    const age = document.getElementById("petAge").value;
    const isAvailable = document.getElementById("petAvailable").value;

    if (!name || !breed || !age) {
        alert("Please fill all fields.");
        return;
    }

    const formData = new URLSearchParams();
    formData.append("name", name);
    formData.append("breed", breed);
    formData.append("age", age);
    formData.append("isAvailable", isAvailable);

    fetch("pets", {
        method: "POST",
        body: formData
    })
        .then(response => response.text())
        .then(message => {
            alert(message);
            viewPets();
        })
        .catch(error => {
            alert("Error adding pet.");
            console.error(error);
        });
}