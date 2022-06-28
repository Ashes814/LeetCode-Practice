
describe("threeSum", function () {

    it("[-1,0,1,2,-1,-4], return [[-1,-1,2],[-1,0,1]]", function() {
      assert.equal(threeSum([-1, 0, 1, 2, -1, -4]), [[-1, -1, 2], [-1, 0, 1]]);
    });

    it("[] , return []", function() {
      assert.equal(threeSum([]), []);
      });

    it("[0] , return []", function() {
      assert.equal(threeSum([0]), []);
    });
  
  });