
$( function() {
    $( "#sortable" ).sortable({
        revert: true
});

$( "ul, li" ).disableSelection();} );

    var groupA=["Russia","Saudi Arabia","Egypt", "Uruguay"];
    for (var i = 0; i < groupA.length; ++i) {
    console.log(groupA[i]);
    }