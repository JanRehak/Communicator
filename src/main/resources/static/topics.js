document.addEventListener("DOMContentLoaded", () => {
    loadTopics();
});

const storeTopic = (_name) => {
    const req = new XMLHttpRequest();
    req.open("POST", "./api/topics");
    req.setRequestHeader('Content-Type', 'application/json');
    const newTopic = {
        name: _name
    }
    req.send(JSON.stringify(newTopic));
};

const loadTopics = () => {
    const reqt = new XMLHttpRequest();
    reqt.addEventListener('load', () => {
        const tableBody = document.getElementById('topic-list');
        tableBody.innerHTML = '';
        const messages = JSON.parse(reqt.responseText);
        messages.forEach(topic => createRow(tableBody, topic));
    });
    reqt.open("GET", "./api/topics");
    reqt.send();
};


const createRow = (tableBody, topic) => {
    const nameCell = document.createElement('td');
    nameCell.innerText = topic.name;

    const idCell = document.createElement('td');
    idCell.innerText = topic.id;

    const topicRow = document.createElement('tr');
    topicRow.append(nameCell, idCell);
    tableBody.append(topicRow);


};