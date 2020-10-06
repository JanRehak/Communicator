const storeMessage = (_content, _name) => {
     console.log(_content, _name);
    const req = new XMLHttpRequest();
//    req.addEventListener('load', loadMessages);
    req.open("POST", "./api/messages");
    req.setRequestHeader('Content-Type', 'application/json');
    const newMessage = {
        content: _content,
        topic: {
            name: _name
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


