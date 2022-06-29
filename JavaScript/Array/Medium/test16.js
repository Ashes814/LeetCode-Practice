
describe("threeSumClosest", function () {

    it("nums = [-1,2,1,-4], target = 1, return 2", function() {
      assert.equal(threeSumClosest([-1,2,1,-4], 1), 2);
    });

    it("nums = [0,0,0], target = 1", function() {
      assert.equal(threeSumClosest([0,0,0], 1), 0);
      });

    // it("[0] , return []", function() {
    //   assert.equal(threeSumClosest([0]), []);
    // });
  
  });