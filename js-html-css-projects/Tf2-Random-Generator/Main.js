
const classes = ["Scout","Soldier","Pyro","Demoman","Heavy","Engineer","Medic","Sniper","Spy"];
const slots = ["Primary","Secondary","Melee"];

const adjectives = ["Big","Rambunctious","Aerodynamic","Angular","Chunky","Convoluted","Cuboid","Graceful","Pointy","Rugged","Solid",
"Twisted","Special","Direct","Grand","Indirect","Prominent","Sacred","Conspicuous","Immovable","Essential","Metallic","Useful","Slender",
"Dangerous","Shiny","Fragile","Formidable","Pious","Crazed"];
const scoutAdjectives = ["Boston","Runner's","Speedy"];
const soldierAdjectives = ["American","Patriot's"];
const pyroAdjectives = ["Dragon's","Incendiary"];
const demomanAdjectives = ["Scotsman's","Explosive"];
const heavyAdjectives = ["Soviet's","Russian","Heavy"];
const engineerAdjectives = ["Texan's","Southern","Frontier"];
const medicAdjectives = ["German's","Bavarian"];
const sniperAdjectives = ["Australian","Sydney"];
const spyAdjectives = ["Frenchman's","Stealthy","Sneaky","French"];

const combinedAdjectives = [scoutAdjectives,soldierAdjectives,pyroAdjectives,demomanAdjectives,heavyAdjectives,
    engineerAdjectives,medicAdjectives,sniperAdjectives,spyAdjectives]

const nouns = ["Blaster","Shooter","Maul","Slasher","Thraser","Inferno","Cutter","Slicer","Shotgun","Legion","Legacy","Honor",
"Rifle","Cannon","Maker","Blade","Crusher","Hellfire","Abomination","Conqueror","Deflector","Katana"];
const meleeNouns = ["Maul","Slasher","Cutter","Slicer","Blade","Katana","Deflector","Knife","Pan","Fish","Bat","Hammer"]

const scoutNouns = ["Scattergun","Pistol","Lunch Box","Substance","Bat"];
const soldierNouns = ["Rocket Launcher","Shotgun","Banner","Boots","Shovel"];
const pyroNouns = ["Flame Thrower","Shotgun","Flare Gun","Substance","Fire axe"];
const demomanNouns = [];
const heavyNouns = [];
const engineerNouns = [];
const medicNouns = [];
const sniperNouns = [];
const spyNouns = [];

const combinedNouns = [scoutNouns,soldierNouns,pyroNouns,demomanNouns,heavyNouns,engineerNouns,medicNouns,spyNouns];
function getAdjective(tfClass){
    let adjective= "";
    if (getRandomNum(0,4) != 0){ // 80% chance of regular adjective
        adjective = adjectives[getRandomNum(0,adjectives.length-1)];
    }
    else{
        adjective = tfClass.adjectives[getRandomNum(0,tfClass.adjectives.length-1)];
    }
    return adjective;
}
function getNoun(slot){
    if (slot == "Melee"){
        return meleeNouns[getRandomNum(0,meleeNouns.length-1)];
    }
    return nouns[getRandomNum(0,nouns.length-1)];
}
function getRandomWeapon(tfClass){
    let index = getRandomNum(0,slots.length-1);
    const weapon = {
        class: tfClass, // the class of the weapon
        slot: slots[index], // the slot the weapon goes in
        adjective: getAdjective(tfClass), // adjective for the weapon
        noun: getNoun(slots[index]), // noun for the weapon
        //type: getType(tfClass),
        level: getRandomNum(0,100)
    };
    return weapon;
}
function getClass(classIndex){
    const tfClass = {
        name: classes[classIndex],
        adjectives: combinedAdjectives[classIndex],
        nouns: combinedNouns[classIndex],
        index: classIndex
    };
    return tfClass;
}
function getRandomNum(min,max){
    return Math.floor(Math.random() * ((max - min + 1) + min));
}
function Main(){
    let classIndex = getRandomNum(0,9);
    const tfClass = getClass(classIndex);
    const weapon = getRandomWeapon(tfClass);
    console.log("A new " + weapon.slot + " for the " + weapon.class.name + ", The " + weapon.adjective + " " + weapon.noun);
}
Main();