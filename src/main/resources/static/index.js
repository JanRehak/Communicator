document.addEventListener("DOMContentLoaded", () => {
	loadMessages();
});

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