


function groupAnagrams(strs) {
  groupArray = [];
  for (let i = 0; i < strs.length; i++) {
    let tempArray = [strs[i]];

    for (let j = i + 1; j < strs.length; j++) {
      if (isAngram(strs[i], strs[j])) {
        tempArray.push(strs[j]);
        strs.splice(j, 1)
        j--;
      }  
    } 
    groupArray.push(tempArray);
  }

  return groupArray;
}




function isAngram(str1, str2) {
  if (str1.length !== str2.length) {
    return false;
  }

  if (Array.from(str1).sort().join("") !== Array.from(str2).sort().join("")) {
    return false
  }

  return true;
}

console.log(groupAnagrams(['ddddddddddg', 'dgggggggggg']));
console.log(isAngram('ddddddddddg', 'dgggggggggg'));
// console.log(Array.from('eat').sort().join("") === Array.from('aet').sort().join(""))