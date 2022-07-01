/*
解题思路1: 
创建一个函数用于判断两个字符串是否相等,思路是进行排序后比较
相等则加入临时列表,循环两层后加入最终结果列表.


*/

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



/*
解题思路2: 
利用hash的思想,将每个子串使用质数乘法进行hash, 只要两个字符串包含的字符与对应数量一致,hash结果则一致： 例如: 'abc' = 2*3*4 'acb' = 2*4*3 然后通过哈希表Map将我们的答案保存。 复杂度分析： 时间复杂度O(mn) m为字符串平均长度,n为strs.length 空间复杂度O(mn) 因为需要将结果保存到map中 
*/



var groupAnagrams = function (strs) {
    const n = strs.length;
    const ans = new Map();
    const prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103];
    const mod = 1e9 + 7;
    for (let i = 0; i < n; i++) {
        let hash = 1;
        for (let j = 0; j < strs[i].length; j++) {
            let num = strs[i].charCodeAt(j) - 97;
            hash = ((hash % mod) * (prime[num] % mod)) % mod;
        }
        if (!ans.get(hash)) ans.set(hash, []);
        ans.get(hash).push(strs[i]);
    }
    return [...ans.values()];
};