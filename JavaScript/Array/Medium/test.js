
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