// Pure EventBus
function subscribe(listeners, eventType, callback, id = 0) {
    const temp = Array.from(listeners);
    temp.push([eventType, callback, id]);
    return temp;
}

function unsubscribe(listeners, eventType, id = 0) {
    return listeners.filter(element => !(element[0] == eventType && element[2] == id));
}

function publish(listeners, eventType, params = []) {
    return listeners.filter(element => element[0] === eventType).map(element =>
        [element[0], element[1].bind(this, ...params)]);
}

// Example
function invokeSubs(subs) {
    subs.forEach(element => element[1]()); 
}

var listeners = [];

listeners = subscribe(listeners, 'event', () => console.log('1'), 0);
listeners = subscribe(listeners, 'event2', (a, b) => console.log(a > b));

invokeSubs(publish(listeners, 'event'));
invokeSubs(publish(listeners, 'event2', [1, 2]));

listeners = subscribe(listeners, 'event', () => console.log('2'), 1);

invokeSubs(publish(listeners, 'event'));
invokeSubs(publish(listeners, 'event2', [5, 3]));
invokeSubs(publish(listeners, 'event3'));

listeners = unsubscribe(listeners, 'event', 0);

invokeSubs(publish(listeners, 'event'));

// Console output
// 1
// false
// 1
// 2
// true
// 2
