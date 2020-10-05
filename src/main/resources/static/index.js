document.addEventListener("DOMContentLoaded", () => {
	loadMessages();
});

const loadMessages = () => {
    const req = new XMLHttpRequest();
    req.addEventListener('load', () => {
        const tableBody = document.getElementById('messages-list');
        tableBody.innerHTML = '';
        const messages = JSON.parse(req.responseText);
        messages.forEach(message => createRow(tableBody, message));
    });
    req.open("GET", "./api/messages");
    req.send();
};

const createRow = (tableBody, message) => {
    const nameCell = document.createElement('td');
    nameCell.innerText = message.author.name;
    const contentCell = document.createElement('td');
    const contentParagraph = document.createElement('p');
    const idCell = document.createElement('td');
    idCell.innerText = `id:${message.id}`;
    contentParagraph.innerText = message.content;
    const commentsTable = document.createElement('table');
    contentCell.append(contentParagraph, commentsTable);
    const timeCell = document.createElement('td');
    timeCell.innerText = message.createdTime;
    const messageRow = document.createElement('tr');
    messageRow.append(nameCell, contentCell, idCell, timeCell);
    tableBody.append(messageRow);


};