import * as cw from "../src/CodeWars";
import { assert } from "chai";

export module CodeWarsTests
{
    describe("CodeWars Unit Tests", function()
    {
        it("sumDigits", function()
        {
            assert.equal(cw.sumDigits(101),2);
            assert.equal(cw.sumDigits(-1230),6);
        });

        it("oddCount", function()
        {
            assert.equal(cw.oddCount(10),5);
            assert.equal(cw.oddCount(35),17);
        });

        it("factorial", function()
        {
            assert.equal(cw.factorial(0),1);
            assert.equal(cw.factorial(5),120);
        });

        it("getMiddle", function()
        {
            assert.equal(cw.getMiddle("f"),"f");
            assert.equal(cw.getMiddle("middle"),"dd");
        });

        it("partsSums", function()
        {
            assert.sameDeepOrderedMembers(cw.partsSums([]), [0]);
            assert.sameDeepOrderedMembers(cw.partsSums([0, 1, 2, 3]),[6, 6, 5, 3, 0]);
        });

        it("meeting", function()
        {
            assert.equal(cw.meeting("lopez:gabriel;lopez:fernando;lopez:daisy;lopez:francisco"),
                "(DAISY, LOPEZ)(FERNANDO, LOPEZ)(FRANCISCO, LOPEZ)(GABRIEL, LOPEZ)");
        });

        it("isMultipleOf3and5", function()
        {
            assert.equal(cw.isMultipleOf3and5(5), 10);
            assert.equal(cw.isMultipleOf3and5(15),105);
        });

        it("tribonacci", function()
        {
            assert.sameDeepOrderedMembers(cw.tribonacci([1, 2, 3],0),[]);
            assert.sameDeepOrderedMembers(cw.tribonacci([1, 2, 3],6),[1, 2, 3, 6, 11, 20]);
        });

        it("digitize", function()
        {
            assert.sameDeepOrderedMembers(cw.digitize(5432),[2, 3, 4, 5]);
        });

        it("Human Readable", function()
        {
            assert.equal(cw.humanReadable(86400),"24:00:00");
            assert.equal(cw.humanReadable(359999),"99:59:59");
        });
    });
}