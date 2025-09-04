<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="content/css/invoice.css">
    </head>
    <body>

        <div class = "invoice-wrapper" id = "print-area">
            <div class = "invoice">
                <div class = "invoice-container">
                    <div class = "invoice-head">
                        <div class = "invoice-head-top">
                            <div class = "invoice-head-top-left text-start">
                                <img src = "content/carBackground.png">
                            </div>
                            <div class = "invoice-head-top-right text-end">
                                <h3>Invoice</h3>
                            </div>
                        </div>
                        <div class = "hr"></div>
                        <div class = "invoice-head-middle">
                            <div class = "invoice-head-middle-left text-start">
                                <p><span class="text-bold">Date</span>: <span id="currentDate"></span></p>
                    	</div>
                            <div class = "invoice-head-middle-right text-end">
                                <p><spanf class = "text-bold">Invoice No:</span><c:out value="${bridges.payment_id}"/></p> <!-- payment id -->
                            </div>
                        </div>
                        <div class = "hr"></div>
                        <div class = "invoice-head-bottom">
                            <div class = "invoice-head-bottom-left">
                                <ul>
                                    <li class = 'text-bold'>Invoiced To:</li>
                                    <li><c:out value="${bridges.user_name}"/></li> <!-- username -->
                                    <li><c:out value="${bridges.rr_address}"/></li> <!-- user_address -->
                                    <li><c:out value="${bridges.user_email}"/></li> <!-- user email -->
                                </ul>
                            </div>
                            <div class = "invoice-head-bottom-right">
                                <ul class = "text-end">
                                    <li class = 'text-bold'>Info Details:</li>
                                    <li><c:out value="${bridges.rr_experience}"/> Experience</li>
                                    <li><c:out value="${bridges.rr_license}"/></li>
                                    <li><c:out value="${bridges.rr_pNum}"/></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class = "overflow-view">
                        <div class = "invoice-body">
                            <table>
                                <thead>
                                    <tr>
                                        <td class = "text-bold">Car ID</td>
                                        <td class = "text-bold">Car Details</td>
                                        <td class = "text-bold">Plat No</td>
                                        <td class = "text-bold">Booking Date</td>
                                        <td class = "text-bold">End Date</td>
                                        <td class = "text-bold">Pickup Location</td>
                                        <td class = "text-bold">Drop Location</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><c:out value="${bridges.car_id}"/></td>
                                        <td><c:out value="${bridges.car_type}"/>, <c:out value="${bridges.car_brand}"/>, <c:out value="${bridges.car_model}"/></td>
                                        <td><c:out value="${bridges.car_plate}"/></td>
                                        <td><c:out value="${bridges.booking_date}"/></td>
                                        <td><c:out value="${bridges.end_date}"/></td>
                                        <td><c:out value="${bridges.pickup_location}"/></td>
                                        <td><c:out value="${bridges.drop_location}"/></td> <!-- class = "text-end" -->
                                    </tr>
                                   
                                </tbody>
                            </table>
                            <div class = "invoice-body-bottom">
                               
                                <div class = "invoice-body-info-item border-bottom">
                                    <div class = "info-item-td text-end text-bold">Price/Day:</div>
                                    <div class = "info-item-td text-end">RM<c:out value="${bridges.price_per_day}"/> /Day</div>
                                </div> 
                                <div class = "invoice-body-info-item border-bottom">
                                    <div class = "info-item-td text-end text-bold">Booking Days:</div>
                                    <div class = "info-item-td text-end"><c:out value="${bridges.booking_days}"/> Day(s)</div>
                                </div> 
                                <div class = "invoice-body-info-item">
                                    <div class = "info-item-td text-end text-bold">Total Price:</div>
                                    <div class = "info-item-td text-end">RM<c:out value="${bridges.totalPrice}"/></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class = "invoice-foot text-center">
                              <p><span class = "text-bold text-center">NOTE:&nbsp;</span>This is computer generated receipt and does not require physical signature.</p>

                        <div class = "invoice-btns">
                            <button type = "button" class = "invoice-btn" onclick="printInvoice()">
                                <span>
                                    <i class="fa-solid fa-print"></i>
                                </span>
                                <span>Print</span>
                            </button>
                            <button type = "button" class = "invoice-btn" onclick="location.href='ListOfPaymentRRController'">
                                <span>
                                    <!-- <i class="fa-solid fa-download"></i>  -->
                                </span>
                                <span>Back</span>
                            </button> 
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src = "js/invoice.js"></script>
        <script>
    // Set current date dynamically using JavaScript
    var currentDateElement = document.getElementById("currentDate");
    var currentDate = new Date().toISOString().slice(0, 10); // Get YYYY-MM-DD format
    currentDateElement.innerText = currentDate;
</script>
    </body>
</html>