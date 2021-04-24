$(document).ready(function(){
    $('.count').prop('disabled', true);
    $(document).on('click','.plus',function(){
        $('.count').val(parseInt($('.count').val()) + 1 );
        changeSum()
    });
    $(document).on('click','.minus',function(){
        $('.count').val(parseInt($('.count').val()) - 1 );
        if ($('.count').val() == 0) {
            $('.count').val(1);
        }
        changeSum()
    });
});

function changeSum() {
    let ingrSum = 0;
    let ingrs = "";
    for(let i = 1; i < 6; i++) {
        if(document.getElementById("checkbox" + i).checked) {
            ingrSum = ingrSum + parseInt(document.getElementById(i + "h").value )
            ingrs = ingrs +  i + " ";
        }
    }
    console.log(ingrSum)
    document.getElementById("sumId").innerHTML="SUM:" + document.orderForm.qty.value * (parseInt(document.getElementById("drinkCostH").value) + ingrSum)
    document.getElementById("finalCostH").value=document.orderForm.qty.value * (parseInt(document.getElementById("drinkCostH").value) + ingrSum)
    document.getElementById("finalDrinkIngrsH").value = ingrs;
    document.getElementById("finalDrinkQuantH").value = document.orderForm.qty.value;
}
