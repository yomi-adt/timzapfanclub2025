const url = "http://example.com/movies.json";


const emailField = document.querySelector("input[type=email]");
const usernameField = document.querySelector("input[type=username]");
const passwordField = document.querySelector("input[type=password]");

// `document.querySelector` may return null if the selector doesn't match anything.


var currentEmail;
var currentUsername;
var currentPassword;


const getLoginInfo = async () => {
    const response = await fetch(url);
    const loginInfo = await response.json(); //extract JSON from the http response

    currentEmail = loginInfo.currentEmail;
    currentUsername = loginInfo.currentUsername;
    currentPassword = loginInfo.currentPassword;
}


// getLoginInfo();
currentEmail = "asldf@sldfa.sdf";
currentUsername = "testusername";
currentPassword = "testpassword123";


if (emailField && currentEmail) {
    emailField.value = currentEmail;
}
if (usernameField && currentUsername) {
    usernameField.value = currentUsername;
}
if (passwordField && currentPassword) {
    passwordField.value = currentPassword;
}