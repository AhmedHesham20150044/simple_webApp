function checkForm(form)
{
    if (form.id.value.length !== 8 ) {
        alert("Error: ID not valid!");
        form.id.focus();
        return false;
    }
    var id = parseInt(form.id.value, 10);
  
}

function checkFormA(form)
{
    if (form.id.value.length !== 8 ) {
        alert("Error: ID not valid!");
        form.id.focus();
        return false;
    }
    if (form.name.value.length < 1) {
        alert("Error: you must enter name!");
        form.name.focus();
        return false;
    }
    if (form.address.value.length < 1) {
        alert("Error: you must enter address!");
        form.address.focus();
        return false;
    }
    if (form.gpa.value.length < 1) {
        alert("Error: you must enter GPA!");
        form.gpa.focus();
        return false;
    }
    var GPA = parseFloat(form.gpa.value);
    if (GPA > 4 ||  GPA < 0) {
        alert("Error: GPA not valid!");
        form.gpa.focus();
        return false;
    }
    return true;
}





