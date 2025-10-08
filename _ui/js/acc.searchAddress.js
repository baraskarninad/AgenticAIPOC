// In /storerepo/_ui/js/acc.searchAddress.js
$("#useSelectedButton").off("click").on("click", function() {
    const selectedAddress = $("input[name='address']:checked").val();
    if (!selectedAddress) {
        alert("Please select an address before proceeding.");
        return false;
    }
    // existing logic to use selected address
});