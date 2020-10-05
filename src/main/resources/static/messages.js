document.addEventListener("DOMContentLoaded", () => {
	loadMessages();
});

const storeMessage = (_content) => {
    console.log(_content);
    const req = new XMLHttpRequest();
//    req.addEventListener('load', loadMessages);
    req.open("POST", "./api/messages");
    req.setRequestHeader('Content-Type', 'application/json');
    const newMessage = {
    	message: _content
    };
    req.send(JSON.stringify(newMessage));
};

const loadMessages = () => {
        const req = new XMLHttpRequest();
        req.addEventListener('load', () => {
            const tableBody = document.getElementById('messages-list');
            tableBody.innerHTML = '';
            const messages = JSON.parse(req.responseText);
            messages.message.forEach(message => createRow(tableBody, message));
        });
        req.open("GET", "./api/messages");
        req.send();
    };