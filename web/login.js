$(document).ready(function () {
    const signUpForm = $(".sign-up form");
    const nameField = $("#name");
    const addrField = $("input[name='addr']");
    const emailField = $("#email");
    const contactField = $("#contact");
    const nameRegex = /^[A-Za-z\s]+$/;
    const addrRegex = /^[A-Za-z\s]{1,12}$/; 
    const emailRegex = /^[a-zA-Z0-9._-]+@gmail\.com$/;
    const contactRegex = /^\d{10}$/; 

    function validateName() {
        const nameValue = nameField.val().trim();
        const nameError = $("#name-error"); 

        if (!nameValue.match(nameRegex) || nameValue.length > 15) {
            nameError.text("Invalid name.");
            return false;
        }

        nameError.text(""); 
        return true;
    }

    function validateAddress() {
        const addrValue = addrField.val().trim();
        const addrError = $("#addr-error"); 

        if (addrValue.length > 12) {
            addrError.text("Please enter a valid address."); 
            return false;
        }

        addrError.text(""); 
        return true;
    }

    nameField.on("blur", validateName);

    addrField.on("blur", validateAddress);

    emailField.on("blur", function () {
        const emailError = $("#email-error"); 

        if (!emailField.val().match(emailRegex)) {
            emailError.text("Please enter a valid email."); 
        } else {
            emailError.text(""); 
        }
    });

    contactField.on("blur", function () {
        const contactError = $("#contact-error"); 

        if (!contactField.val().match(contactRegex)) {
            contactError.text("Phone number should be 10 digits."); 
        } else {
            contactError.text(""); 
        }
    });

    document.getElementById('photo').addEventListener('change', function () {
        const fileInput = this;
        const errorMessage = document.getElementById('Img-error');
        
        if (fileInput.files.length > 0) {
            const selectedFile = fileInput.files[0];
            const validExtensions = ['.jpeg'];

            const fileExtension = selectedFile.name.split('.').pop().toLowerCase();
            
            if (!validExtensions.includes('.' + fileExtension)) {
                errorMessage.textContent = 'Please select a valid image file JPEG.';
                fileInput.value = ''; 
            } else {
                errorMessage.textContent = ''; 
            }
        }
    });


    signUpForm.on("submit", function (event) {
        let valid = true;

        if (!validateName()) {
            valid = false;
        }

        if (!validateAddress()) {
            valid = false;
        }

        if (!emailField.val().match(emailRegex)) {
            valid = false;
        }

        if (!contactField.val().match(contactRegex)) {
            valid = false;
        }

        if (!valid) {
            event.preventDefault();
        }
    });

    const wrapper = $(".wrapper");
    const signUpLink = $(".signUp-link");
    const signInLink = $(".signIn-link");

    signUpLink.on('click', function () {
        wrapper.addClass('animate-signIn');
        wrapper.removeClass('animate-signUp');
    });

    signInLink.on('click', function () {
        wrapper.addClass('animate-signUp');
        wrapper.removeClass('animate-signIn');
    });
});
