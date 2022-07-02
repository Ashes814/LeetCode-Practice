/*
解题思路: 
首先将数组按照左端点进行排序,
如果数组长度为一,直接返回该数组
比较这个数组的右端点与下一个数组的左端点,如果大于等于,则将这个数组的右端点与下个数组的右端点中大的那个加入到临时区间的右端点,进入下一个循环;
如果这个数组的右端点小于下个数组的左端点,则将临时数组加入最终结果,将临时数组更新为下一个数组,反复循环
时间复杂度(不算排序):o(n)
空间复杂度:o(n)



*/


const merge = function (intervals) {
  intervals.sort(sortByFirst);
  let finalArray = [];
  if (intervals.length === 1) {
    finalArray.push(intervals[0])
  }
  let tempArray = [intervals[0][0], intervals[0][1]];
  for (let i = 0; i < intervals.length - 1;) {
    if (tempArray[1] >= intervals[i + 1][0]) {
      tempArray[1] = Math.max(tempArray[1], intervals[i + 1][1]);
      i++;
      if (i === intervals.length - 1) {
        finalArray.push(tempArray);
      }
    } else {
      finalArray.push(tempArray);
      tempArray = [intervals[i + 1][0], intervals[i + 1][1]]
      i++
      if (i === intervals.length - 1) {
        finalArray.push(tempArray);
      }
    }
  }
  
  // for (let i = 0; i < intervals.length;) {
  //   if (i === intervals.length - 1) {
  //     finalArray.push([intervals[i][0], intervals[i][1]]);
  //     break
  //   }
  //   let tempArray = []
  //   tempArray[0] = intervals[i][0];
  //   for (let j = i + 1; j < intervals.length; j++) {
  //     if (j === intervals.length - 1) {
  //       if (intervals[i][1] >= intervals[j][0]) {
  //         tempArray[1] = (intervals[i][1] > intervals[j][1]) ? intervals[i][1] : intervals[j][1];
  //         finalArray.push(tempArray)
  //         break
  //       } else {
  //         tempArray[1] = 
  //       }

  //     }
  //     if (intervals[i][1] >= intervals[j][0]) {
  //       continue
  //     } else {
  //       if (intervals[i][1] >= intervals[j - 1][1]) {
  //         tempArray[1] = intervals[i][1];
  //       } else {
  //         tempArray[1] = intervals[j - 1][1];
  //       }
  //     }
  //     finalArray.push(tempArray)
  //     i = j;
  //     break
  //   } 
  // }
  return finalArray;
};


// console.log([[1, 3], [2, 6], [8, 10], [15, 18], [2, 7], [11, 14]].sort(sortByFirst))
function sortByFirst(a, b) {
  if (a[0] === b[0]) {
    return 0;
  } else {
    return (a[0] > b[0]) ? 1 : -1;
  }
}
// 
// console.log(merge([[1,4],[4,5]]))
// console.log(merge([[1,3],[2,6],[8,10],[15,18]]))
console.log(merge([[1,3]]))