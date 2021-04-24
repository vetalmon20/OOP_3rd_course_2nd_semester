function depositMoney() {
    document.getElementById("moneyText").innerHTML = (parseInt(document.getElementById("moneyText").innerHTML) + parseInt(document.getElementById("moneyToDeposit").value)).toString();
    document.getElementById("finalMoneyAmountH").value = document.getElementById("moneyText").innerHTML;
}