// In /storerepo/_ui/js/acc.searchAddress.js
$(document).on('click', '.use-selected-btn', function(e) {
    var selectedAddress = $('.address-list .selected').data('address');
    // Fix: Also check if selectedAddress is an empty object or empty string.
    if (!selectedAddress || selectedAddress === '' || (typeof selectedAddress === 'object' && Object.keys(selectedAddress).length === 0)) {
        e.preventDefault();
        alert('Please select an address before proceeding.');
        return;
    }
    // existing logic for using the selected address
});