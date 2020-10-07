document.addEventListener("DOMContentLoaded", () => {
    loadTopics();
    loadTopicsSelect();
});

const storeMessage = (_content, _id) => {
    //  console.log(_content, _name);
    const req = new XMLHttpRequest();
//    req.addEventListener('load', loadMessages);
    req.open("POST", "./api/messages");
    req.setRequestHeader('Content-Type', 'application/json');
    
    
    const newMessage = {
        content: _content,
        topic: {
            
            id: _id
        }
    };
    req.send(JSON.stringify(newMessage));
};




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

const loadTopicsSelect = () => {
    console.log('test/start funkce loadTopicsSelect()');
    const reqt = new XMLHttpRequest();
    reqt.addEventListener('load', () => {
        const select = document.getElementById('topics');
        // select.innerHTML = '';
        const topics = JSON.parse(reqt.responseText);
        console.log('test');
        topics.forEach(topic => createOption(select, topic));
    });
    reqt.open("GET", "./api/topics");
    reqt.send();
};


const createOption = (select, topic) => {
    const opt = document.createElement('option');
    opt.value = topic.id;
    // opt.name = topic.name;
    opt.name = "test";
    opt.innerHTML = topic.name;
    
    select.appendChild(opt);


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

