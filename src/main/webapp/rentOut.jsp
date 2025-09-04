<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Automobile Rental Service</title>
    <link rel="stylesheet" href="./content/css/rentOut.css">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@3.5.0/fonts/remixicon.min.css" rel="stylesheet">
    <script src="https://unpkg.com/scrollreveal@4.0.9/dist/scrollreveal.js"></script>
</head>

<body>

<input type="checkbox" id="bars">
<nav class="nav-bar" id="navbar">
    <div class="content">
        <div class="logo nav__logo">
            <a href="#"><img src="content/carBackground.png" alt="logo"/>
                <h1>MyCars</h1>
            </a>
        </div>

        <ul class="navigation">
            <li class="link"><a href="homePage.jsp">home</a></li>
            <li class="link"><a href="#bookForm">form</a></li>
            <img src="content/setting3.png" class="user-pic" onclick="toggleMenu()">

            <div class="sub-menu-wrap" id="subMenu">
          <div class="sub-menu">
            <div div class="user-info">
              <i class="ri-profile-line"></i>
              <h2>Settings</h2>
            </div>
            <hr>

            <a href="viewProfileController" class="sub-menu-link">
              <img src="content/profile.png" alt="">
              <p>Profile</p>
              <span>></span>
            </a>
            <a href="ListOfBookingRRController" class="sub-menu-link">
              <img src="content/booking.png" alt="">
              <p>Your Booking</p>
              <span>></span>
            </a>
            <a href="ListCarRRController" class="sub-menu-link">
              <img src="content/car.png" alt="">
              <p>Your Car</p>
              <span>></span>
            </a>
            <a href="ListOfPaymentRRController" class="sub-menu-link">
              <img src="content/payment.png" alt="">
              <p>History</p>
              <span>></span>
            </a>
            <a href="logoutController" class="sub-menu-link">
              <img src="content/logout.png" alt="">
              <p>Logout</p>
              <span>></span>
            </a>
          </div>
        </div>
        </ul>

        <label for='bars' class="icon-bars"><i class="ri-bar-chart-2-fill"></i></label>
    </div>
</nav>

<header class="home" id="home">
    <div class="content">
        <h1>Become <strong>our</strong> peers <strong>now</strong></h1>
        <h4>You can earn more income by renting out your car</h4>
    </div>
</header>

<div class="background" id="bookForm">
    <div class="booking-form">
        <h2>Enter Car Details</h2>
        <form action="addCarController" method="post">
            
            <label for="userID">User ID:</label>
            <input type="number" name="userID" id="userID" value="${user_id}" readonly>
            <label for="carBrand">Car Brand:</label>
            <select id="carBrand" name="carBrand" required onchange="updateCarModels()">
                <option value="NULL">Select Option</option>
                <option value="Perodua">Perodua</option>
                <option value="Proton">Proton</option>
            </select>
            <label for="carModel">Car Model:</label>
            <select id="carModel" name="carModel" required onchange="updatePriceAndType()">
                <option value="NULL">Select Option</option>
            </select><br>

			<label for="carType">Car Type:</label>
            <input type="text" name="carType" id="carType" required readonly>
            <label for="carColor">Car Color:</label>
            <input type="text" name="carColor" id="carColor" required>
            <label for="noSeat">No Of Seats:</label>
            <input type="number" name="noSeat" id="noSeat" value="5" readonly required>
            <label for="availability">Available:</label>
            <input type="text" name="availability" id="availability" value="Available" required readonly>
            
            <input type="hidden" name="ownerBusy" id="ownerBusy" value="false" required >
            <label for="pricePerDay">Price Per Day: RM</label>
            <input type="number" name="pricePerDay" id="pricePerDay" step="0.01" required>
            
            <label for="carPlate">Car Plate Number:</label>
            <input type="text" name="carPlate" id="carPlate" required>
            <button type="submit">Rent Out Now</button>
        </form>
    </div>
</div>

<script>
    const carModels = {
        Perodua: ['Myvi', 'Axia', 'Kancil', 'Bezza'],
        Proton: ['Wira', 'Persona']
    };

    function updateCarModels() {
        const carBrand = document.getElementById('carBrand').value;
        const carModelSelect = document.getElementById('carModel');

        // Clear existing options
        carModelSelect.innerHTML = '<option value="NULL">Select Option</option>';

        // Add new options based on the selected car brand
        if (carModels[carBrand]) {
            carModels[carBrand].forEach(model => {
                const option = document.createElement('option');
                option.value = model;
                option.textContent = model;
                carModelSelect.appendChild(option);
            });
        }
    }

    function updatePriceAndType() {
        const carModel = document.getElementById('carModel').value;
        //const pricePerDayField = document.getElementById('pricePerDay');
        const carTypeField = document.getElementById('carType');

        let price;
        //let carType;
        switch(carModel) {
            case 'Bezza':
                //price = 90.00;
                carType = 'Sedan';
                break;
            case 'Myvi':
                //price = 80.00;
                carType = 'Hatchback';
                break;
            case 'Axia':
                //price = 80.00;
                carType = 'Hatchback';
                break;
            case 'Kancil':
                //price = 70.00;
                carType = 'Hatchback';
                break;
            case 'Persona':
                //price = 90.00;
                carType = 'Sedan';
                break;
            case 'Wira':
                //price = 80.00;
                carType = 'Sedan';
                break;
            default:
                //price = 0;
                carType = '';
        }

        //console.log("Price Set:", price);
        console.log("Car Type Set:", carType);
        //pricePerDayField.value = price.toFixed(2);
        carTypeField.value = carType;
    }
</script>
<script src="./js/homePage.js"></script>

</body>

</html>
