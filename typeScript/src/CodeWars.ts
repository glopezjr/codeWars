export function sumDigits(num: number) : number
{
    let sum = 0;
    let numStr = num.toString();

    numStr = numStr.replace("-", "");

    for (let i = 0; i < numStr.length; i++)
        sum += parseInt(numStr.charAt(i));

    return sum;
}

export function oddCount(n: number) : number
{
    return Math.ceil((n - 1) / 2);
}

export function factorial(n: number) : number
{
    if (n == 0)
        return 1;

    let answer = 1;

    for (let i = n; i > 0; i--)
        answer *= i;

    return answer;
}

export function getMiddle(s: string) : string
{
    if (s.length == 1)
        return s;

    if (s.length % 2 == 0)
        return s.charAt((s.length / 2) - 1) + s.charAt(s.length / 2);
    else
        return s.charAt(s.length / 2);
}

export function partsSums(ls: number[]): number[]
{
    if (ls.length == 0)
        return [0];

    let resultArray: number[] = [ls.length + 1];
    let res: number = 0;

    for (let i: number = 0; i < ls.length; i++)
        res += ls[i];

    resultArray[0] = res;

    for (let i: number = 0; i < ls.length; i++)
    {
        res -= ls[i];
        resultArray[i + 1] = res;
    }

    resultArray[resultArray.length - 1] = 0;
    return resultArray;
}

export function meeting(s: string): string
{
    let strArr: string[] = s.toLowerCase().trim().split(";");
    let answer: string = "";

    for (let i: number = 0; i < strArr.length; i++)
        strArr[i] = strArr[i].substring(strArr[i].indexOf(':') + 1, strArr[i].length)
            + " " + strArr[i].substring(0, strArr[i].indexOf(':'));

    strArr.sort();

    for (let j: number = 0; j < strArr.length; j++)
        answer += "(" + strArr[j].split(' ').join(', ').toUpperCase() + ")";

    return answer;
}

export function isMultipleOf3and5(n: number): number
{
    let answer = 0;

    for (let i = 1; i < n; i++)
    {
        if (n % 3 == 0 && n % 5 != 0)
            answer += i;
        else if (n % 5 == 0 && n % 3 != 0)
            answer += i;
        else if (n % 3 == 0 && n % 5 == 0)
            answer += i;
    }

    return answer;
}

export function tribonacci([a, b, c]: [number, number, number], n: number): number[]
{
    let trib = [a, b, c];

    if (n == 0)
        return [];
    else if (n < trib.length)
    {
        trib = [n];

        for (let i = 0; i < n; i++)
            trib[i] = [a, b, c][i];
        return trib;
    }
    else
    {
        switch (trib.length)
        {
            case 1:
                trib.push(trib[0], trib[0]);
                for (let i = 3; i < n; i++)
                    trib[i] = trib[i - 1] + trib[i - 2] + trib[i - 3];
                break;

            case 2:
                trib.push(trib[0]);
                for (let i = 3; i < n; i++)
                    trib[i] = trib[i - 1] + trib[i - 2] + trib[i - 3];
                break;

            default:
                for (let i = trib.length; i < n; i++)
                    trib[i] = trib[i - 1] + trib[i - 2] + trib[i - 3];
                break;
        }

        return trib;
    }
}

export const digitize = (n: number): number[] =>
{
    let numStrArr: string[] = n.toString().split('');
    numStrArr.reverse();
    let answer: number[] = [numStrArr.length];

    for (let i = 0; i < numStrArr.length; i++)
        answer[i] = parseInt(numStrArr[i]);

    return answer;
};

export function humanReadable(seconds:number):string
{
    let hh = Math.floor(seconds / 3600).toString();
    seconds %= 3600;
    let mm = Math.floor(seconds / 60).toString();
    let ss = "" + (seconds % 60);

    if (parseInt(hh) < 10)
        hh = "0" + hh;
    if (parseInt(mm) < 10)
        mm = "0" + mm;
    if (parseInt(ss) < 10)
        ss = "0" + ss;

    return hh + ":" + mm + ":" + ss;
}